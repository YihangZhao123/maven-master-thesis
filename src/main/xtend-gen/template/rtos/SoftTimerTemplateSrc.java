package template.rtos;

import fileAnnotation.FileType;
import fileAnnotation.FileTypeAnno;
import template.templateInterface.InitTemplate;

@FileTypeAnno(type = FileType.C_SOURCE)
@SuppressWarnings("all")
public class SoftTimerTemplateSrc implements InitTemplate {
  @Override
  public String create() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field Generator.sdfcombSet refers to the missing type Vertex"
      + "\ngetIdentifier cannot be resolved");
  }
  
  @Override
  public String getFileName() {
    return "soft_timer";
  }
}
