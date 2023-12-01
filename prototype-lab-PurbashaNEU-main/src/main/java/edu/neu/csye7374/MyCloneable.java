package edu.neu.csye7374;

import java.util.HashMap;

public abstract class MyCloneable implements Cloneable  {

    protected int id;
    protected double price;
    protected String name;

    public abstract void getID(int id);
    public abstract void getPrice(double price);
    public abstract void getName(String name);
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static class MyCloneableItem extends MyCloneable{

        public MyCloneableItem(int id, double price, String name) {
            this.id = id;
            this.price = price;
            this.name = name;
        }
        @Override
        public void getID(int id) {
            this.id = id;
        }
        @Override
        public void getPrice(double price) {
            this.price = price;
        }
        @Override
        public void getName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "id=" + id + ", price=" + price + ", name=" + name;
        }

        public static class MyCloneableItemBuilder {
            private int id;
            private double price;
            private String name;
            public MyCloneableItemBuilder setId(int id) {
                this.id = id;
                return this;
            }
            public MyCloneableItemBuilder setPrice(double price) {
                this.price = price;
                return this;
            }
            public MyCloneableItemBuilder setName(String name) {
                this.name = name;
                return this;
            }
            public MyCloneableItem build() {
                MyCloneableItem item = new MyCloneableItem(id, price, name);
                return item;
            }
        }
    }

    public static abstract class MyCloneableAbstractFactoryAPI {
        /**
         * @param id            ID of prototype
         * @param prototype        one cloneable prototype object
         */
        public abstract void load(int id, MyCloneable prototype);
        /**
         * dynamically load list of prototypes
         *
         * @param prototypeList        list of cloneable prototype objects
         */
        public abstract void load(HashMap<Integer, MyCloneable> prototypeList);
        /**
         * return clone of requested object
         *
         * @param id            ID of requested object
         * @return                cloned object
         */
        public abstract MyCloneable getObject(int id);
    }

    public static class MyCloneableAbstractFactory extends MyCloneableAbstractFactoryAPI {
        private HashMap<Integer, MyCloneable> prototypeList = new HashMap<Integer, MyCloneable>();
        @Override
        public void load(int id, MyCloneable prototype) {
            prototypeList.put(id, prototype);
        }
        @Override
        public void load(HashMap<Integer, MyCloneable> prototypeList) {
            this.prototypeList = prototypeList;
        }
        @Override
        public MyCloneable getObject(int id) {
            MyCloneable prototype = prototypeList.get(id);
            try {
                return (MyCloneable) prototype.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static class MyCloneableAbstractFactorySingleton {
        private static MyCloneableAbstractFactorySingleton instance = null;
        private MyCloneableAbstractFactorySingleton() {
        }
        public static MyCloneableAbstractFactorySingleton getInstance() {
            if (instance == null) {
                instance = new MyCloneableAbstractFactorySingleton();
            }
            return instance;
        }
        public MyCloneableAbstractFactoryAPI getObject() {
            return new MyCloneableAbstractFactory();
        }
    }
}

