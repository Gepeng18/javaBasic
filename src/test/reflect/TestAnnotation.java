package reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestAnnotation {
    public static void main(String[] args) throws Exception {
        Class entityClass = Class.forName("reflect.Entity");
        Annotation[] annotations = entityClass.getAnnotations();
        for (Annotation an : annotations) {
            System.out.println(an);
        }

        ClassAnnotation classAnnotation = (ClassAnnotation) entityClass.getAnnotation(ClassAnnotation.class);
        if(classAnnotation!=null)
            System.out.println(classAnnotation.value());

        Field nameField = entityClass.getDeclaredField("name");
        MethodAnnotation methodAnnotation = nameField.getAnnotation(MethodAnnotation.class);
        if(methodAnnotation!=null){
            System.out.println(methodAnnotation.value());
        }
    }
}
