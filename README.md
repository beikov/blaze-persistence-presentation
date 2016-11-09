# Blaze-Persistence Presentations

This repository collects presentations about blaze-persistence along with demos.

## Blaze-Persistence Demo

The demo provides REST resources showcasing various blaze-persistence features.
It is integrated with Swagger, the API description can be retrieved via `/swagger.json`.

[Swagger UI](https://github.com/swagger-api/swagger-ui) can be used to conveniently invoke the resources.
Unfortunately, Swagger does not have good support for local API description files. Follow these steps to setup Swagger UI locally:

* Download and unpack Swagger UI

* Retrieve the API JSON description and create a file `/dist/spec.js` in the Swagger UI home directory containing:

```js   
var spec = <api-json-description>;
```

* Edit `/dist/index.html` and insert the following `<script>` tag to include `/dist/spec.js`:

```xml
<script src='spec.js' type="text/javascript"></script>
```

* Pass the `spec` var as argument to SwaggerUi in `/dist/spec.js`:

```js
window.swaggerUi = new SwaggerUi({
        url: url,
		spec: spec,
		...
});
```