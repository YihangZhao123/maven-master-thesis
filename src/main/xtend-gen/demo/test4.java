package demo;

import com.google.common.base.Objects;
import forsyde.io.java.core.EdgeTrait;
import forsyde.io.java.core.ForSyDeSystemGraph;
import forsyde.io.java.core.Vertex;
import forsyde.io.java.core.VertexProperty;
import forsyde.io.java.core.VertexTrait;
import forsyde.io.java.drivers.ForSyDeModelHandler;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class test4 {
  public static void main(final String[] args) {
    try {
      ForSyDeSystemGraph model = new ForSyDeSystemGraph();
      final EdgeTrait t = EdgeTrait.MOC_SDF_SDFDATAEDGE;
      test4.addVertex(model);
      test4.addchannel(model);
      test4.connectChannel(model, "s_in", "p1", "consumer", "s_in", t);
      test4.connectChannel(model, "s1", "p2", "consumer", "s1", t);
      test4.connectChannel(model, "s2", "p4", "consumer", "s4", t);
      test4.connectChannel(model, "s3", "p3", "consumer", "s3", t);
      test4.connectChannel(model, "s4", "p5", "consumer", "s4", t);
      test4.connectChannel(model, "s5", "p3", "consumer", "s5", t);
      test4.connectChannel(model, "s6", "p1", "consumer", "s6", t);
      test4.connectChannel(model, "p1", "s1", "s1", "producer", t);
      test4.connectChannel(model, "p2", "s2", "s2", "producer", t);
      test4.connectChannel(model, "p2", "s3", "s3", "producer", t);
      test4.connectChannel(model, "p4", "s4", "s4", "producer", t);
      test4.connectChannel(model, "p5", "s5", "s5", "producer", t);
      test4.connectChannel(model, "p3", "s6", "s6", "producer", t);
      test4.connectChannel(model, "p4", "s_out", "s_out", "producer", t);
      new ForSyDeModelHandler().writeModel(model, "a.fiodl");
      new ForSyDeModelHandler().writeModel(model, "a.forsyde.xmi");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static boolean connectChannel(final ForSyDeSystemGraph model, final String srcname, final String dstname, final String srcport, final String dstport, final EdgeTrait t) {
    return model.connect(model.queryVertex(srcname).get(), model.queryVertex(dstname).get(), srcport, dstport, t);
  }
  
  public static void addchannel(final ForSyDeSystemGraph model) {
    List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("s_in", "s_out", "s1", "s2", "s3", "s4", "s5", "s6"));
    for (final String name : list) {
      {
        Set<String> ports = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("producer", "consumer"));
        int maxtoken = 0;
        boolean _equals = Objects.equal(name, "s1");
        if (_equals) {
          maxtoken = 1;
        }
        boolean _equals_1 = Objects.equal(name, "s2");
        if (_equals_1) {
          maxtoken = 1;
        }
        boolean _equals_2 = Objects.equal(name, "s3");
        if (_equals_2) {
          maxtoken = 2;
        }
        boolean _equals_3 = Objects.equal(name, "s4");
        if (_equals_3) {
          maxtoken = 1;
        }
        boolean _equals_4 = Objects.equal(name, "s5");
        if (_equals_4) {
          maxtoken = 2;
        }
        boolean _equals_5 = Objects.equal(name, "s6");
        if (_equals_5) {
          maxtoken = 2;
        }
        boolean _equals_6 = Objects.equal(name, "s_in");
        if (_equals_6) {
          maxtoken = 10;
        }
        boolean _equals_7 = Objects.equal(name, "s_out");
        if (_equals_7) {
          maxtoken = 10;
        }
        VertexProperty _create = VertexProperty.create(maxtoken);
        Pair<String, VertexProperty> _mappedTo = Pair.<String, VertexProperty>of("maximumTokens", _create);
        Map<String, VertexProperty> properties = Collections.<String, VertexProperty>unmodifiableMap(CollectionLiterals.<String, VertexProperty>newHashMap(_mappedTo));
        Vertex a = new Vertex(name, ports, properties);
        a.addTraits(VertexTrait.MOC_SDF_SDFCHANNEL, VertexTrait.DECISION_SDF_BOUNDEDSDFCHANNEL);
        a.addTraits(VertexTrait.IMPL_TOKENIZABLEDATABLOCK);
        model.addVertex(a);
      }
    }
  }
  
  public static boolean addVertex(final ForSyDeSystemGraph model) {
    throw new Error("Unresolved compilation problems:"
      + "\nAmbiguous feature call.\nThe methods\n\tconnect(Vertex, Vertex, String, String, EdgeTrait[]) in ForSyDeSystemGraph and\n\tconnect(Vertex, Vertex, String, String, String[]) in ForSyDeSystemGraph\nboth match."
      + "\nAmbiguous feature call.\nThe methods\n\tconnect(Vertex, Vertex, String, String, EdgeTrait[]) in ForSyDeSystemGraph and\n\tconnect(Vertex, Vertex, String, String, String[]) in ForSyDeSystemGraph\nboth match."
      + "\nAmbiguous feature call.\nThe methods\n\tconnect(Vertex, Vertex, String, String, EdgeTrait[]) in ForSyDeSystemGraph and\n\tconnect(Vertex, Vertex, String, String, String[]) in ForSyDeSystemGraph\nboth match.");
  }
}
