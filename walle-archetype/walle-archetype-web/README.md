### 脚手架生成项目
```shell script
mvn archetype:generate \
-DgroupId=simon \
-DartifactId=mydemo-service \
-Dversion=1.0.0-SNAPSHOT \
-Dpackage=simon.mydemo \
-DarchetypeGroupId=jxf \
-DarchetypeArtifactId=walle-archetype-web \
-DarchetypeVersion=1.0.0 \
-DinteractiveMode=false
```
