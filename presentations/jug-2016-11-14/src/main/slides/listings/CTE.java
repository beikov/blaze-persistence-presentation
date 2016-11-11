public <T> List<T> getCatHierarchy(Integer catId, EntityViewSetting<T, CriteriaBuilder<T>> setting) {
    CriteriaBuilder<Tuple> cb = cbf.create(emHolder.getEntityManager(), Tuple.class)
            .withRecursive(CatHierarchyCTE.class)
                .from(Cat.class)
                .bind("id").select("id")
                .bind("motherId").select("mother.id")
                .bind("fatherId").select("father.id")
                .bind("generation").select("0")
                .where("id").eqExpression(catId.toString())
            .unionAll()
                .from(Cat.class, "cat")
                .from(CatHierarchyCTE.class, "cte")
                .bind("id").select("cat.id")
                .bind("motherId").select("cat.mother.id")
                .bind("fatherId").select("cat.father.id")
                .bind("generation").select("cte.generation + 1")
                .whereOr()
                    .where("cat.id").eqExpression("cte.motherId")
                    .where("cat.id").eqExpression("cte.fatherId")
                .endOr()
            .end()
            .from(Cat.class, "cat")
            .innerJoinOn(CatHierarchyCTE.class, "cte").on("cte.id").eqExpression("cat.id").end()
            .orderByAsc("cte.generation");

    return evm.applySetting(setting, cb).getResultList();
}