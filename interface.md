### 登录

```
简述:登录
url:/user/login
method:post
参数:username(用户名),password(密码)
返回示例:
{
    "status": 0,
    "msg": 成功~",
    "data":{
        "id":1,
        "username":"root",
        "password":null,
        "phoneNum":"123456",
        "email":"xx@163.com",
        "gender":"男"
    }
}
{
    "status": 1,
    "msg": "用户名或密码错误!"
}
```

### 注册

```
简述:通过用户名注册账户,并且用户名不可重复。
url:/user/register
method:post
参数:
- username
- password
- phonenum
- email
- gender
返回示例:
{
	"status": 0,
	"msg": "注册成功~",
	"data":{
		"id": 1,
		"username": "zhangsan",
	}
}
{
	"status": 1,
	"msg": "该用户名已存在!"
}
```



### 买车页面 所有车的信息

```
简述:拿到所有车的品牌、车系、燃料类型等信息
url:/buy/index
method:get
参数:无
返回示例:
{
    "status": 0,
    "msg": 成功~",
    "data":{
        "brand" : ["a","b",c"],
        "series" : ["x","a","c"]
    }
}
{
    "status": 1,
    "msg": "我是你爹!"
}
```



### 获取所有的品牌

```
简述:拿到所有的品牌信息
url:/buy/brands
method:get
参数:无
返回示例:
{
    "status": 0,
    "msg": "查询成功",
    "data": [
        "奥迪",
        "阿斯顿·马丁",
        "蒙迪欧",
        "阿尔法·罗密欧",
        "Elise",
        "ALPINA",
        "奔驰",
        "本田",
        "宝来/宝来经典",
        "悍马H2",
        "北斗星",
        "宝骏",
        "来宝SRV",
        "保时捷",
        "北京",
        "北汽幻速",
        "领航员",
        "北汽制造",
        "里程",
        "宾利",
        "北汽绅宝",
        "北汽昌河",
        "奇骏(进口)",
        "巴博斯",
        "北汽威旺",
        "宝马X3(进口)",
        "北汽道达",
        "爱迪尔",
        "神行者2",
        "赛欧",
        "梅甘娜",
        "长安轻型车",
        "长安跨越",
        "大众"
    ]
}
{
    "status": 1,
    "msg": "我是你爹!"
}
```

### 根据品牌查询车系,10条

```
简述:拿到所有的品牌信息
url:/buy/seriesLimit
method:get
参数:brand
返回示例:
{
    "status": 0,
    "msg": "查询成功",
    "data": [
        "奥迪A3",
        "奥迪A4L",
        "奥迪A6L",
        "奥迪A6L新能源",
        "奥迪Q3",
        "奥迪Q5",
        "奥迪RS 4",
        "奥迪RS 3",
        "奥迪RS 6",
        "奥迪RS 7"
    ]
}
{
    "status": 1,
    "msg": "我是你爹!"
}
```



### **根据品牌查全部车系**

``` 
简述:根据品牌查全部车系
url:/buy/series
method:get
参数:brand
返回示例:
{
    "status": 0,
    "msg": "查询成功",
    "data": [
        "奥迪A3",
        "奥迪A4L",
        "奥迪A6L",
        "奥迪A6L新能源",
        "奥迪Q3",
        "奥迪Q5",
        "奥迪RS 4",
        "奥迪RS 3",
        "奥迪RS 6",
        "奥迪RS 7",
        "奥迪R8",
        "奥迪TT RS",
        "奥迪A1",
        "奥迪A3(进口)",
        "奥迪A3新能源(进口)",
        "奥迪S3",
        "奥迪A4(进口)",
        "奥迪A5",
        "奥迪S5",
        "奥迪A6(进口)",
        "奥迪S6",
        "奥迪A7",
        "奥迪S7",
        "奥迪A8",
        "奥迪S8",
        "奥迪Q5(进口)",
        "奥迪SQ5",
        "奥迪Q7",
        "奥迪Q7新能源",
        "奥迪TT",
        "奥迪TTS"
    ]
}
{
    "status": 1,
    "msg": "我是你爹!"
}
```



### 获取车的详细信息

```
简述:根据条件查询
url:/buy/car/details/{id}
method:get
参数:
- id   id直接拼在uri后面
返回示例:
{
    "status": 0,
    "msg": "success",
    "data": {
        "id": 2,
        "carId": 11,
        "price": 20000,
        "km": 50,
        "color": "红",
        "status": 1,
        "views": 211,
        "storeId": 5,
        "userId": 2,
        "createTime": "2021-06-21T17:20:49.000+00:00",
        "buyTime": "2019-04-01T22:17:56.000+00:00",
        "car": {
            "id": 11,
            "brand": "奥迪",
            "series": "奥迪A3",
            "model": "奥迪A3 2018款 30周年年型 Limousine 40 TFSI 风尚型",
            "structure": "4门5座三厢车",
            "fuel": "汽油",
            "price": "20000"
        }
    }
}
{
    "status": 1,
    "msg": "我是你爹!"
}
```





### 多条件组合查询

```
简述:根据条件查询
url:/buy/queryInfo
method:get
参数:
- brand 品牌
- series 车系
- price 价格区间 Stirng 格式：15-20
返回示例:
{
    "status": 0,
    "msg": "success",
    "data": {
        "total": 7,
        "list": [
            {
                "id": 1,
                "carId": 10,
                "price": "50000",
                "km": 11,
                "color": "黑",
                "status": 0,
                "views": 20,
                "storeId": 2,
                "userId": "1",
                "createTime": "2021-06-22T16:42:45.000+00:00",
                "car": {
                    "id": 1,
                    "brand": "奥迪",
                    "series": "奥迪A3",
                    "model": "奥迪A3 2018款 30周年年型 Limousine 35 TFSI 运动型",
                    "structure": "4门5座三厢车",
                    "fuel": "汽油",
                    "price": "50000"
                }
            },
            {
                "id": 2,
                "carId": 11,
                "price": "20000",
                "km": 50,
                "color": "红",
                "status": 1,
                "views": 211,
                "storeId": 5,
                "userId": "2",
                "createTime": "2021-06-21T17:20:49.000+00:00",
                "car": {
                    "id": 2,
                    "brand": "奥迪",
                    "series": "奥迪A3",
                    "model": "奥迪A3 2018款 30周年年型 Limousine 40 TFSI 风尚型",
                    "structure": "4门5座三厢车",
                    "fuel": "汽油",
                    "price": "20000"
                }
            },
            {
                "id": 3,
                "carId": 14,
                "price": "30000",
                "km": 12,
                "color": "白",
                "status": 0,
                "views": 213,
                "storeId": 2,
                "userId": "2",
                "createTime": "2021-06-23T18:34:05.000+00:00",
                "car": {
                    "id": 3,
                    "brand": "奥迪",
                    "series": "奥迪A4L",
                    "model": "奥迪A4L 2018款 30周年年型 40 TFSI 进取型",
                    "structure": "4门5座三厢车",
                    "fuel": "汽油",
                    "price": "30000"
                }
            },
            {
                "id": 4,
                "carId": 42,
                "price": "51000",
                "km": 23,
                "color": "红",
                "status": 0,
                "views": 123,
                "storeId": 2,
                "userId": "1",
                "createTime": "2021-06-23T18:34:43.000+00:00",
                "car": {
                    "id": 4,
                    "brand": "奥迪",
                    "series": "奥迪RS 7",
                    "model": "奥迪RS 7 2016款 RS 7 4.0T Sportback",
                    "structure": "5门4座掀背车",
                    "fuel": "汽油",
                    "price": "51000"
                }
            },
            {
                "id": 5,
                "carId": 21,
                "price": "89213",
                "km": 5,
                "color": "绿",
                "status": 0,
                "views": 123,
                "storeId": 2,
                "userId": "4",
                "createTime": "2021-06-23T18:35:14.000+00:00",
                "car": {
                    "id": 5,
                    "brand": "奥迪",
                    "series": "奥迪A6L",
                    "model": "奥迪A6L 2018款 30周年年型 35 TFSI 运动型",
                    "structure": "4门5座三厢车",
                    "fuel": "汽油",
                    "price": "89213"
                }
            }
        ],
        "pageNum": 1,
        "pageSize": 5,
        "size": 5,
        "startRow": 1,
        "endRow": 5,
        "pages": 2,
        "prePage": 0,
        "nextPage": 2,
        "isFirstPage": true,
        "isLastPage": false,
        "hasPreviousPage": false,
        "hasNextPage": true,
        "navigatePages": 8,
        "navigatepageNums": [
            1,
            2
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 2,
        "firstPage": 1,
        "lastPage": 2
    }
}
{
    "status": 1,
    "msg": "我是你爹!"
}
```





### 卖车

```
简述:根据品牌查全部车系
url:/sale/index
method:post
参数:品牌 brand
    车型 series
    车型 model
    买车时间 buyTime
    行驶里程  km
    颜色 color
  	价格 price
返回示例:
{
    "status": 0,
    "msg": "查询成功",
    "data": [
        "奥迪A3",
        "奥迪A4L",
        "奥迪A6L",
        "奥迪A6L新能源",
        "奥迪Q3",
        "奥迪Q5",
        "奥迪RS 4",
        "奥迪RS 3",
        "奥迪RS 6",
        "奥迪RS 7",
        "奥迪R8",
        "奥迪TT RS",
        "奥迪A1",
        "奥迪A3(进口)",
        "奥迪A3新能源(进口)",
        "奥迪S3",
        "奥迪A4(进口)",
        "奥迪A5",
        "奥迪S5",
        "奥迪A6(进口)",
        "奥迪S6",
        "奥迪A7",
        "奥迪S7",
        "奥迪A8",
        "奥迪S8",
        "奥迪Q5(进口)",
        "奥迪SQ5",
        "奥迪Q7",
        "奥迪Q7新能源",
        "奥迪TT",
        "奥迪TTS"
    ]
}
{
    "status": 1,
    "msg": "我是你爹!"
}
```

