#!/bin/bash

function run_psql() {
local sql_input="$1"
docker compose exec postgres sh -c "PGPASSWORD=secret psql -U myuser -h localhost spring_with_crac" <<EOF
$sql_input
EOF
}

run_psql "drop table dog "
run_psql "`cat data.sql`"
run_psql "select id, name from dog"