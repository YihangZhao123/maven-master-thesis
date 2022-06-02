package template.rtos;

import fileAnnotation.FileType;
import fileAnnotation.FileTypeAnno;
import template.templateInterface.InitTemplate;

@FileTypeAnno(type = FileType.C_INCLUDE)
@SuppressWarnings("all")
public class ExternalDataBlockInc implements InitTemplate {
  @Override
  public String create() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method findAllExternalDataBlocks(ForSyDeSystemGraph) is undefined for the type Class<Query>"
      + "\nThe field Generator.model refers to the missing type ForSyDeSystemGraph"
      + "\ngetIdentifier cannot be resolved"
      + "\ntoUpperCase cannot be resolved"
      + "\ngetIdentifier cannot be resolved"
      + "\ntoUpperCase cannot be resolved"
      + "\ngetIdentifier cannot be resolved"
      + "\ntoUpperCase cannot be resolved");
  }
  
  @Override
  public String getFileName() {
    return "extern_datablock";
  }
}
