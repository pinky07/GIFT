#!/bin/sh
#

echo 'Running e2e tests...'
cd client
npm run e2eh
echo 'e2e finished.'
