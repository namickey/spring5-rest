echo curl -X GET localhost:8080/tasks
curl -X GET localhost:8080/tasks
echo
echo

echo curl -X POST -H "Content-Type: application/json" -d '{"name":"def"}' localhost:8080/tasks
curl -X POST -H "Content-Type: application/json" -d '{"name":"def"}' localhost:8080/tasks
echo
echo

echo curl -X GET localhost:8080/tasks
curl -X GET localhost:8080/tasks
echo
echo

echo curl -X DELETE -w '%{http_code}\n' localhost:8080/tasks/0
curl -X DELETE -w '%{http_code}\n' localhost:8080/tasks/0
echo
echo

echo curl -X GET localhost:8080/tasks
curl -X GET localhost:8080/tasks
echo
echo
