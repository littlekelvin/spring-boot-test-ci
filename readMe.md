### 运行单元测试
- mvn clean install -P unit -s settings.xml

### 运行集成测试测试
- mvn clean install -P int -s settings.xml

### 运行所有测试
- mvn clean install -P tests -s settings.xml

### 忽略测试构建
- mvn clean install -P skipTests -s settings.xml
- mvn clean install -Dmaven.test.skip=true -s settings.xml