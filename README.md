# summer
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