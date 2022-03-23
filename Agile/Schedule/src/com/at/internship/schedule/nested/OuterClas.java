package com.at.internship.schedule.nested;

public class OuterClas {
    private static final String STATIC_FIELD = "STATIC VALUE";
    private String nonStaticField = "non-static-value";

    public static void main(String[] args) {
        //For nested classes, we can acces the constructos from the class name of the outer class
        OuterClas.NestedClass nestedClass = new OuterClas.NestedClass();
        //In the order to reacho the constructor of an inner classs, que need to create instance od the outer class
        //OuterClas.InnerClass innerClass = new OuterClas.InnerClass();
        OuterClas outerClas = new OuterClas();
        OuterClas.InnerClass innerClass = outerClas.getInnerClass();
    }

    public OuterClas(){
        /**
         *This is a local class
         * Local class are defined into a method and are nor available out of the method that define
         */
        class LocalClass{
            public LocalClass(){
                System.out.println(STATIC_FIELD);
                //Can aacess instance fields
                System.out.println(nonStaticField);
            }
        }
        LocalClass localClass = new LocalClass();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(STATIC_FIELD);
                //Can aacess instance fields
                System.out.println(nonStaticField);
            }
        };

    }

    public OuterClas(String param){
        NestedClass nestedClass = new NestedClass();

    }

    /**
     * This is nested class
     * Nested classes ara always static and con only access static
     */
    public static class NestedClass{
        public NestedClass(){
            System.out.println(STATIC_FIELD);
            //Cannot acces iinstance fields
        }
    }

    /**
     * This is an inner class
     * This class can only be creates forma an instance of OuterClass and can acces all the fields
     * define into OuterClass, even instance fields
     */
    public class InnerClass{
        public InnerClass(){
            System.out.println(STATIC_FIELD);
            System.out.println(nonStaticField);

        }
    }

    public InnerClass getInnerClass(){
        return new InnerClass();
    }
}

class PackageClass{

}