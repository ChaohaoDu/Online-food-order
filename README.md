# Online-food-order
## Overview

![project structure](https://tva1.sinaimg.cn/large/e6c9d24egy1h6kv5yvvqej20l60didgk.jpg)

This projects consists of 7 smaller services:

1. `eureka-server` responses the connection with other servers and the load balance.
2. `configServer` provides corresponding configs for other services.
3. `account` provides the login features for both normal customer users and admins.
4. `user` provides the features for users adding/deleting/updating/querying.
5. `menu` provides the features  for courses adding/deleting/updating/querying.
6. `order` provides the features for orders adding/deleting/updating/querying.
7. `client` is the interface interactive with users. After the user places the order, `client` will send a message to the queue, which will resolved by other services.

## Get started

1. Fill the `xxx` parts of the files under  `configServer/src/main/resources/shared`, and add any other configs if you want.
2. Start the services in the order of 
   1. `eureka-server(8761)`
   2. `configServer(8762)`
   3. `account(8050)`/`menu(8020)`/`order(8010)`/`user(8040)`
   4. `client(8030)`

> If you meet the port conflict,
>
> 1. Kill the process that using that port
> 2. Change the `server.port` of the server config under `configServer/src/main/resources/shared` directory.

