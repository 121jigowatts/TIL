# PostgreSQL

## 基本コマンド

psqlでPostgreSQLを操作する基本的なコマンド。

### ログイン

```sh
# ロール名指定
psql -U postgres
```

### データベース一覧表示

```sh
\l
```

### データベース変更

```sh
\c
```

### テーブル一覧表示

```sh
\dt;
```

### 設定

```sh
# select結果を縦に整列表示する
\x auto
```

## SQL

### JSONB型

#### JSONB型のテーブル作成

```sql
CREATE TABLE IF NOT EXISTS messages (
  id SERIAL PRIMARY KEY,
  jsonb_value JSONB
);
```

#### JSONB型のデータ登録

```sql
INSERT INTO messages (
  jsonb_value
) VALUES (
  json_build_object('key', 1, 'database_name', 'PostgreSQL', 'schemas', json_build_object('schema_name', 'admin', 'tables', json_build_object('table_name', 'members', 'columns', json_build_object('id', 1, 'name', 'alice', 'age', 17))))
);
```

#### JSONB型のデータ取得

```sql
select id,jsonb_value from messages;
-[ RECORD 1 ]----------------------------------------------------------------------------------------------------------------------------------------------------------------------
id          | 1
jsonb_value | {"key": 1, "schemas": {"tables": {"columns": {"id": 1, "age": 17, "name": "alice"}, "table_name": "members"}, "schema_name": "admin"}, "database_name": "PostgreSQL"}
```

最上位層は`->>`にて条件を指定する。

```sql
select * from messages where jsonb_value->>'key'='1';
-[ RECORD 1 ]----------------------------------------------------------------------------------------------------------------------------------------------------------------------
id          | 1
text        | hello postgres
jsonb_value | {"key": 1, "schemas": {"tables": {"columns": {"id": 1, "age": 17, "name": "alice"}, "table_name": "members"}, "schema_name": "admin"}, "database_name": "PostgreSQL"}
```

より深い層は`->`を組み合わせる。

```sql
select * from messages where jsonb_value->'schemas'->'tables'->'columns'->>'id'='1';
-[ RECORD 1 ]----------------------------------------------------------------------------------------------------------------------------------------------------------------------
id          | 1
text        | hello postgres
jsonb_value | {"key": 1, "schemas": {"tables": {"columns": {"id": 1, "age": 17, "name": "alice"}, "table_name": "members"}, "schema_name": "admin"}, "database_name": "PostgreSQL"}
```
