echo "Killing: `cat run_trade_api_server.pid`"
kill -9 `cat run_trade_api_server.pid`
rm -rf run_trade_api_server.pid
