# scheduler

---
title: task2
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.30"

---

# task2

Base URLs:

# Authentication

# Default

## POST create

POST /schedules

> Body Parameters

```json
{
  "contents": "contents1",
  "writer": "writer1",
  "password": "password1",
  "writeTime": "2025-05-24",
  "updateTime": "2025-05-24"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» contents|body|string| yes |none|
|» writer|body|string| yes |none|
|» password|body|string| yes |none|
|» writeTime|body|string| yes |none|
|» updateTime|body|string| yes |none|

> Response Examples

> 201 Response

```json
{
  "id": 9,
  "contents": "contents1",
  "writer": "writer1",
  "writeTime": "2025-05-24",
  "updateTime": "2025-05-24"
}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|201|[Created](https://tools.ietf.org/html/rfc7231#section-6.3.2)|none|Inline|

### Responses Data Schema

HTTP Status Code **201**

|Name|Type|Required|Restrictions|Title|description|
|---|---|---|---|---|---|
|» id|integer|true|none||none|
|» contents|string|true|none||none|
|» writer|string|true|none||none|
|» writeTime|string|true|none||none|
|» updateTime|string|true|none||none|

## GET read all

GET /schedules

> Response Examples

> 200 Response

```json
[
  {
    "id": 7,
    "contents": "contents7 수정",
    "writer": "writer7 수정",
    "writeTime": "2025-05-22",
    "updateTime": "2025-05-24"
  },
  {
    "id": 9,
    "contents": "contents1",
    "writer": "writer1",
    "writeTime": "2025-05-24",
    "updateTime": "2025-05-24"
  },
  {
    "id": 10,
    "contents": "contents8",
    "writer": "writer8",
    "writeTime": "2025-05-24",
    "updateTime": "2025-05-24"
  },
  {
    "id": 5,
    "contents": "title3 수정",
    "writer": "writer3 수정",
    "writeTime": "2025-05-21",
    "updateTime": "2025-05-22"
  },
  {
    "id": 6,
    "contents": "title2",
    "writer": "writer2",
    "writeTime": "2025-05-22",
    "updateTime": "2025-05-22"
  },
  {
    "id": 8,
    "contents": "title4 수정",
    "writer": "writer4 수정",
    "writeTime": "2025-05-22",
    "updateTime": "2025-05-22"
  }
]
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

HTTP Status Code **200**

|Name|Type|Required|Restrictions|Title|description|
|---|---|---|---|---|---|
|» id|integer|true|none||none|
|» contents|string|true|none||none|
|» writer|string|true|none||none|
|» writeTime|string|true|none||none|
|» updateTime|string|true|none||none|

## GET read one

GET /

> Response Examples

> 200 Response

```json
{
  "id": 9,
  "contents": "contents1",
  "writer": "writer1",
  "writeTime": "2025-05-24",
  "updateTime": "2025-05-24"
}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|

### Responses Data Schema

HTTP Status Code **200**

|Name|Type|Required|Restrictions|Title|description|
|---|---|---|---|---|---|
|» id|integer|true|none||none|
|» contents|string|true|none||none|
|» writer|string|true|none||none|
|» writeTime|string|true|none||none|
|» updateTime|string|true|none||none|

## PATCH update

PATCH /schedules/7

> Body Parameters

```json
{
  "contents": "contents7 수정",
  "writer": "writer7 수정",
  "password": "password4"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» contents|body|string| yes |none|
|» writer|body|string| yes |none|
|» password|body|string| yes |none|

> Response Examples

> 200 Response

```json
{
  "id": 7,
  "contents": "contents7 수정",
  "writer": "writer7 수정",
  "writeTime": "2025-05-22",
  "updateTime": "2025-05-24"
}
```

> 400 Response

```json
{
  "timestamp": "2025-05-23T16:18:01.470+00:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/schedules/7"
}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|none|Inline|

### Responses Data Schema

HTTP Status Code **200**

|Name|Type|Required|Restrictions|Title|description|
|---|---|---|---|---|---|
|» id|integer|true|none||none|
|» contents|string|true|none||none|
|» writer|string|true|none||none|
|» writeTime|string|true|none||none|
|» updateTime|string|true|none||none|

HTTP Status Code **400**

|Name|Type|Required|Restrictions|Title|description|
|---|---|---|---|---|---|
|» timestamp|string|true|none||none|
|» status|integer|true|none||none|
|» error|string|true|none||none|
|» path|string|true|none||none|

## DELETE delete

DELETE /schedules/1

> Body Parameters

```json
{
  "contents": "contents1",
  "writer": "writer1",
  "password": "password1",
  "writeTime": "2025-05-24",
  "updateTime": "2025-05-24"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» contents|body|string| yes |none|
|» writer|body|string| yes |none|
|» password|body|string| yes |none|
|» writeTime|body|string| yes |none|
|» updateTime|body|string| yes |none|

> Response Examples

> 200 Response

```
{}
```

> 400 Response

```json
{
  "timestamp": "2025-05-23T16:19:55.434+00:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/schedules/6"
}
```

> 404 Response

```json
{
  "timestamp": "2025-05-23T16:18:50.144+00:00",
  "status": 404,
  "error": "Not Found",
  "path": "/schedules/1"
}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|none|Inline|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|none|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|none|Inline|

### Responses Data Schema

HTTP Status Code **400**

|Name|Type|Required|Restrictions|Title|description|
|---|---|---|---|---|---|
|» timestamp|string|true|none||none|
|» status|integer|true|none||none|
|» error|string|true|none||none|
|» path|string|true|none||none|

HTTP Status Code **404**

|Name|Type|Required|Restrictions|Title|description|
|---|---|---|---|---|---|
|» timestamp|string|true|none||none|
|» status|integer|true|none||none|
|» error|string|true|none||none|
|» path|string|true|none||none|

# Data Schema

