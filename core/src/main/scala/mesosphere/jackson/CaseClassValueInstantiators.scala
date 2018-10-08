package mesosphere.jackson

import com.fasterxml.jackson.databind.deser.{ValueInstantiator, ValueInstantiators}
import com.fasterxml.jackson.databind.{BeanDescription, DeserializationConfig}

import scala.util.Try

protected object CaseClassValueInstantiators extends ValueInstantiators.Base {

  import mesosphere.reflect.classLoaderMirror

  override def findValueInstantiator(config: DeserializationConfig,
                                     beanDesc: BeanDescription,
                                     defaultInstantiator: ValueInstantiator) = {

    Try(classLoaderMirror.classSymbol(beanDesc.getBeanClass)).toOption match {
      case Some(classSymbol) if classSymbol.isCaseClass =>
        new CaseClassValueInstantiator(config, beanDesc)

      case _ => defaultInstantiator
    }
  }
}
