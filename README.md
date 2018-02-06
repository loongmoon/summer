��һ���֣�IoC����
1.step1-�����������
git checkout step-1-container-register-and-get
IoC������Ľ�ɫ������������(BeanFactory)��Bean��������ʹ��BeanDefinition����װ��bean�����������Ա���һЩ�����Ԫ��Ϣ�����Դ��룺

// 1.��ʼ��beanfactory
BeanFactory beanFactory = new BeanFactory();

// 2.ע��bean
BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

// 3.��ȡbean
HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
helloWorldService.helloWorld();
2.step2-��bean�������빤��
git checkout step-2-abstract-beanfactory-and-do-bean-initilizing-in-it
step1�е�bean�ǳ�ʼ����֮����set��ȥ�ģ�ʵ��ʹ���У�����ϣ������������bean�Ĵ������������ǽ�bean�ĳ�ʼ������BeanFactory�С�Ϊ�˱�֤��չ�ԣ�����ʹ��Extract Interface�ķ�������BeanFactory�滻�ɽӿڣ���ʹ��AbstractBeanFactory��AutowireCapableBeanFactory��Ϊ��ʵ�֡�"AutowireCapable"����˼�ǡ����Զ�װ��ġ���Ϊ���Ǻ���ע��������׼����

 // 1.��ʼ��beanfactory
BeanFactory beanFactory = new AutowireCapableBeanFactory();

// 2.ע��bean
BeanDefinition beanDefinition = new BeanDefinition();
beanDefinition.setBeanClassName("us.codecraft.tinyioc.HelloWorldService");
beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

// 3.��ȡbean
HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
helloWorldService.helloWorld();
3.step3-Ϊbeanע������
git checkout step-3-inject-bean-with-property
��һ����������ҪΪbeanע�����ԡ�����ѡ������ע����Ϣ�����PropertyValue���󣬲��ұ��浽BeanDefinition�С������ڳ�ʼ��bean��ʱ�����ǾͿ��Ը���PropertyValue������bean���Ե�ע�롣Spring����ʹ����setter������ע�룬����Ϊ�˴����࣬����ʹ��Field����ʽ��ע�롣

// 1.��ʼ��beanfactory
BeanFactory beanFactory = new AutowireCapableBeanFactory();

// 2.bean����
BeanDefinition beanDefinition = new BeanDefinition();
beanDefinition.setBeanClassName("us.codecraft.tinyioc.HelloWorldService");

// 3.��������
PropertyValues propertyValues = new PropertyValues();
propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!"));
beanDefinition.setPropertyValues(propertyValues);

// 4.����bean
beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

// 5.��ȡbean
HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
helloWorldService.helloWorld();
4.step4-��ȡxml��������ʼ��bean
git checkout step-4-config-beanfactory-with-xml
��ô��һ���ʼ�����������ķ��������BeanDefinitionֻ��һЩ���ã����ǻ�����xml����ʼ���ɡ����Ƕ�����BeanDefinitionReader��ʼ��bean������һ��ʵ����XmlBeanDefinitionReader��

// 1.��ȡ����
XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

// 2.��ʼ��BeanFactory��ע��bean
BeanFactory beanFactory = new AutowireCapableBeanFactory();
for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
        beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
}

// 3.��ȡbean
HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
helloWorldService.helloWorld();
5.step5-Ϊbeanע��bean
git checkout step-5-inject-bean-to-bean
ʹ��xml����֮���ƺ���������֪��Spring������һ��������������һ��������û�н���������޷�����bean֮����������޷���beanע�뵽bean�У��������޷���֮Ϊ������IoC���������ʵ���أ����Ƕ���һ��BeanReference������ʾ��������Ƕ���һ��bean�����á�����ڶ�ȡxml��ʱ���ʼ�������ڳ�ʼ��bean��ʱ�򣬽��н�������ʵbean��ע�롣

for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
    Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
    declaredField.setAccessible(true);
    Object value = propertyValue.getValue();
    if (value instanceof BeanReference) {
        BeanReference beanReference = (BeanReference) value;
        value = getBean(beanReference.getName());
    }
    declaredField.set(bean, value);
}
ͬʱΪ�˽��ѭ�����������⣬����ʹ��lazy-init�ķ�ʽ����createBean������ŵ�getBean��ʱ���ִ�У��ǲ���һ���ӷ���ܶࣿ������ע��bean��ʱ����������Զ�Ӧ��bean�Ҳ�������ô���ȴ�������Ϊ�����ȴ�����ע�룬���Բ����������ѭ��������bean�������������⡣

// 1.��ȡ����
XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

// 2.��ʼ��BeanFactory��ע��bean
AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
    beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
}

// 3.��ʼ��bean
beanFactory.preInstantiateSingletons();

// 4.��ȡbean
HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
helloWorldService.helloWorld();
6.step6-ApplicationContext�ǳ�
git checkout step-6-invite-application-context
����BeanFactory�Ĺ�����ȫ�ˣ�����ʹ�������е��鷳����������������Ϥ��ApplicationContext�ӿڣ�����AbstractApplicationContext��refresh()�����н���bean�ĳ�ʼ��������

ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
helloWorldService.helloWorld();
�ǲ��Ƿǳ���Ϥ������Ϊֹ�����ǵ�tiny-spring��IoC���ֿ�˵�깤�ˡ��ⲿ�ֵ��ࡢ�������������ã����Ƕ�ӦSpring����Ӧ���������Ȼ������ֻ��400���У������Ѿ����˻�����IoC���ܣ�