package generator;

import com.google.common.base.Objects;
import fileAnnotation.FileType;
import fileAnnotation.FileTypeAnno;
import forsyde.io.java.core.Vertex;
import forsyde.io.java.typed.viewers.moc.sdf.SDFActor;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import template.templateInterface.ActorTemplate;
import utils.Save;

@SuppressWarnings("all")
public class SDFCombProcessingModule implements ModuleInterface {
  private Set<ActorTemplate> templates;
  
  public SDFCombProcessingModule() {
    HashSet<ActorTemplate> _hashSet = new HashSet<ActorTemplate>();
    this.templates = _hashSet;
  }
  
  @Override
  public void create() {
    final Predicate<Vertex> _function = (Vertex v) -> {
      return (SDFActor.conforms(v)).booleanValue();
    };
    final Consumer<Vertex> _function_1 = (Vertex v) -> {
      this.process(v);
    };
    Generator.model.vertexSet().stream().filter(_function).forEach(_function_1);
  }
  
  public void process(final Vertex v) {
    final Consumer<ActorTemplate> _function = (ActorTemplate t) -> {
      FileTypeAnno anno = t.getClass().<FileTypeAnno>getAnnotation(FileTypeAnno.class);
      FileType _type = anno.type();
      boolean _equals = Objects.equal(_type, FileType.C_INCLUDE);
      if (_equals) {
        String _create = t.create(v);
        String _savePath = t.savePath();
        String _plus = (Generator.root + _savePath);
        Save.save(_create, _plus);
      }
      FileType _type_1 = anno.type();
      boolean _equals_1 = Objects.equal(_type_1, FileType.C_SOURCE);
      if (_equals_1) {
        String _create_1 = t.create(v);
        String _savePath_1 = t.savePath();
        String _plus_1 = (Generator.root + _savePath_1);
        Save.save(_create_1, _plus_1);
      }
    };
    this.templates.stream().forEach(_function);
  }
  
  public void add(final ActorTemplate t) {
    this.templates.add(t);
  }
}
