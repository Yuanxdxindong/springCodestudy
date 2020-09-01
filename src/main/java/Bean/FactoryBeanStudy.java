package Bean;

import org.springframework.beans.factory.FactoryBean;

    /**
     * @author yuanxindong
     * @date  2020/6/9 8:43 下午
     */
    public  class FactoryBeanStudy implements FactoryBean<Person> {
        private String  personInfo;
        @Override
        public Person getObject() throws Exception {
            Person person = new Person();
            String[] split = personInfo.split(",");
            String s = split[1];
            person.setName(s);
            return person ;
        }

        @Override
        public Class<?> getObjectType() {
            return Person.class;
        }

        @Override
        public boolean isSingleton() {
            return false;
        }


        public void setPersonInfo(String personInfo) {
            this.personInfo = personInfo;
        }
    }
