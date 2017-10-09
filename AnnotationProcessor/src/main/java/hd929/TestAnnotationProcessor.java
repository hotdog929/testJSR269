package hd929;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.Element;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestAnnotationProcessor extends AbstractProcessor {

    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        System.out.println("<<<<< TestAnnotationProcessor Process Init >>>>>");
    }

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        System.out.println("<<<<< TestAnnotationProcessor Process Start >>>>>");

        for(Element ele : roundEnv.getElementsAnnotatedWith(TestAnnotation.class)){
            System.out.println("<<<<< SimpleName : " + ele.getSimpleName() + " >>>>>");

            TestAnnotation ann = ele.getAnnotation(TestAnnotation.class);
            System.out.println("<<<<< Class : " + ann.value() + " >>>>>");
        }

        System.out.println("<<<<< TestAnnotationProcessor Process End >>>>>");

        return true;
    }

    public Set<String> getSupportedAnnotationTypes() {
        Set<String> anns = new LinkedHashSet<String>();
        anns.add(TestAnnotation.class.getCanonicalName());
        return anns;
    }
}
