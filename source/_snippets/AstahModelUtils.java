/*
 * Please change this class's package to your genearated Plug-in's package.
 * Plug-in's package namespace => com.example
 *   com.change_vision.astah.extension.plugin => X
 *   com.example                              => O
 *   com.example.internal                     => O
 *   learning                                 => X
 */
package com.example.internal;

import java.util.ArrayList;
import java.util.List;

import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.model.IAttribute;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IClassifierTemplateParameter;
import com.change_vision.jude.api.inf.model.IElement;
import com.change_vision.jude.api.inf.model.IGeneralization;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.model.IOperation;
import com.change_vision.jude.api.inf.model.IPackage;
import com.change_vision.jude.api.inf.model.IParameter;
import com.change_vision.jude.api.inf.model.IRealization;

public class AstahUtils {

  /**
   * Get classes owned by the owner
   *
   * @param  owner   Class or Package
   * @return Classes nesting in the owner
   */
  public static IClass[] getOwnedClasses(Object owner) {
    if (owner instanceof IClass) {
      return ((IClass) owner).getNestedClasses();
    } else if (owner instanceof IPackage) {
      List<IClass> classes = new ArrayList<IClass>();
      for (INamedElement element : ((IPackage) owner).getOwnedElements()) {
        if (element instanceof IClass) {
          classes.add((IClass) element);
        }
      }
      return classes.toArray(new IClass[classes.size()]);
    } else {
      return new IClass[0];
    }
  }

  /**
   * Get a owner's class whose name is specified 
   *
   * @param owner Class or Package
   * @param name  Owner name
   * @return An owner's class whose name is specified
   */
  public static IClass getOwnedClass(Object owner, String name) {
    if (owner instanceof IClass) {
      return getNestedClass((IClass) owner, name);
    } else if (owner instanceof IPackage) {
      return getOwnedElement((IPackage) owner, name, IClass.class);
    } else {
      return null;
    }
  }


  /**
   * Get an INamedElement whose name is specified in the target package
   *
   * @param owner Target package
   * @param name  Name
   * @return a namedElement whose name is specified in the target package
   */
  public static INamedElement getOwnedElement(IPackage owner, String name) {
    return getOwnedElement(owner, name, INamedElement.class);
  }

  /**
   * Get an Object whose name and type are specified in the target package
   *
   * @param owner       Target package
   * @param name        Name
   * @param elementType The child class type of INamedElement
   * @return  the child class type of INamedElement whose name and type are specified in the target package
   */
  public static <T extends INamedElement> T getOwnedElement(IPackage owner,
      String name, Class<T> elementType) {
    for (INamedElement element : owner.getOwnedElements()) {
      if (name.equals(element.getName())) {
        if (elementType.isInstance(element)) {
          return elementType.cast(element);
        }
      }
    }
    return null;
  }

  /**
   * Get a class whose name is specified in the target class
   *
   * @param owner Target class
   * @param name  Name
   * @return a class whose name is specified in the target class
   */
  public static IClass getNestedClass(IClass owner, String name) {
    for (IClass element : owner.getNestedClasses()) {
      if (name.equals(element.getName())) {
        return element;
      }
    }
    return null;
  }

  /**
   * Get a generalization whose parent class is specified
   *
   * @param owner     Target class
   * @param superType Parent class
   * @return Generalization
   *         Null if the superType isn't generalized by the owner
   */
  public static IGeneralization getGeneralization(IClass owner,
      IClass superType) {
    for (IGeneralization generalization : owner.getGeneralizations()) {
      if (superType.equals(generalization.getSuperType())) {
        return generalization;
      }
    }
    return null;
  }

  /**
   * Get a generalization whose child class is specified
   *
   * @param owner   Target class
   * @param subType Child class
   * @return Generalization
   *         Null if the owner isn't generalized by the subType
   */
  public static IGeneralization getSpecialization(IClass owner, IClass subType) {
    for (IGeneralization generalization : owner.getSpecializations()) {
      if (subType.equals(generalization.getSubType())) {
        return generalization;
      }
    }
    return null;
  }

  /**
   * Get a realization whose supplier class is specified
   *
   * @param owner    Target class
   * @param supplier Supplier Class
   *
   * @return Realization
   *         Null if the owner isn't realized by the supplier
   */
  public static IRealization getClientRealization(IClass owner,
      IClass supplier) {
    for (IRealization realization : owner.getClientRealizations()) {
      if (supplier.equals(realization.getSupplier())) {
        return realization;
      }
    }
    return null;
  }

  /**
   * Get a realization whose client class is specified
   *
   * @param owner    Target class
   * @param client   Client Class
   *
   * @return Realization
   *         Null if the client isn't realized by the owner
   */
  public static IRealization getSupplierRealization(IClass owner,
      IClass client) {
    for (IRealization realization : owner.getSupplierRealizations()) {
      if (client.equals(realization.getClient())) {
        return realization;
      }
    }
    return null;
  }


  /**
   * Get a owner's template parameter whose name is specified
   *
   * @param owner  Target class
   * @param name   Parameter Name
   * @return  Template Parameter
   *          Null if the template parameter dosn't exist
   */
  public static IClassifierTemplateParameter getTemplateParameter(
      IClass owner, String name) {
    for (IClassifierTemplateParameter templateParameter : owner
        .getTemplateParameters()) {
      if (name.equals(templateParameter.getName())) {
        return templateParameter;
      }
    }
    return null;
  }

  /**
   * Get a owner's attribute whose name is specified
   *
   * @param owner Target class
   * @param name  Attribute name
   * @return Attribute
   *         Null if the attribute dosn't exist
   */
  public static IAttribute getAttribute(IClass owner, String name) {
    for (IAttribute attribute : owner.getAttributes()) {
      if (name.equals(attribute.getName())) {
        return attribute;
      }
    }
    return null;
  }

  /**
   * Get a owner's operation whose name is specified。
   *
   * @param owner Target class
   * @param name  Operation name
   * @return Operation
   *         Null if the operation dosn't exist
   */
  public static IOperation getOperation(IClass owner, String name,
      Object[] parameterTypes) {
    for (IOperation operation : owner.getOperations()) {
      if (name.equals(operation.getName())) {
        IParameter[] parameters = operation.getParameters();
        if (matches(parameters, parameterTypes)) {
          return operation;
        }
      }
    }
    return null;
  }

  /**
   * set a class as an interface
   *
   * @param type        Target class
   * @param isInterfase True if the class is an interface
   *                    False if the class isn't an interface
   */
  public static void setInterface(IClass type, boolean isInterface)
      throws InvalidEditingException {
    if (isInterface) {
      addStereotype(type, "interface");
    } else {
      type.removeStereotype("interface");
    }
  }

  /**
   * Add a stereotype to an element
   * @param element Target element
   * @param stereotype Added stereotype
   * @return True if the stereotype is added
   *         False if the stereotype has been owned by the element
   */
  public static boolean addStereotype(IElement element, String stereotype)
      throws InvalidEditingException {
    for (String exists : element.getStereotypes()) {
      if (stereotype.equals(exists)) {
        return false;
      }
    }
    element.addStereotype(stereotype);
    return true;
  }

  static boolean matches(IParameter[] parameters, Object[] parameterTypes) {
    if (parameterTypes.length != parameters.length) {
      return false;
    }
    for (int i = 0; i < parameterTypes.length; i++) {
      Object type = parameterTypes[i];
      if (type instanceof IClass) {
        if (!type.equals(parameters[i].getType())) {
          return false;
        }
      } else {
        if (!type.equals(parameters[i].getTypeExpression())) {
          return false;
        }
      }
    }
    return true;
  }

}
