#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' ) 

$symbol_pound$symbol_pound ${artifactId}


$symbol_pound$symbol_pound$symbol_pound$symbol_pound Apollo配置中心

```shell script
# idea打开Run configuration，VM Option添加以下参数
-Dapollo.meta=http://apollo-config.k8s.likeshuo.group -Denv=dev
```

$symbol_pound$symbol_pound$symbol_pound$symbol_pound 构建打包

```shell script
# -U强制拉取snapshot的依赖
mvn clean install -DskipTests -U
```

