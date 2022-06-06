package generator

import forsyde.io.java.typed.viewers.moc.sdf.SDFActor


import forsyde.io.java.core.Vertex
import java.util.Set
import template.templateInterface.ActorTemplate
import java.util.HashSet
import utils.Save
import utils.Name
import fileAnnotation.FileTypeAnno
import java.lang.reflect.*
import fileAnnotation.FileType

class SDFCombProcessingModule  implements ModuleInterface{
	Set<ActorTemplate> templates
	new (){
		templates= new HashSet
	}
	
	override create() {

		Generator.model.vertexSet().stream().filter([v|SDFActor::conforms(v)]).forEach([v|process(v)])
	}
	
	def void process(Vertex v){
		templates.stream().forEach( [t| 
			
			 var anno = t.getClass(). getAnnotation(FileTypeAnno)
			 		 	
			
			 if(anno.type()==FileType.C_INCLUDE){
			 	Save.save(t.create(v),Generator.root+t.savePath());
			 }
			 
			 if(anno.type()==FileType.C_SOURCE){
			 	Save.save(t.create(v),Generator.root+t.savePath())
			 }
			 
		] )
	}

	def void add(ActorTemplate t){
		templates.add(t)
	}
	
}