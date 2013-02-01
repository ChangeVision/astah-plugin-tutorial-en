/*
 * Please change this class's package to your genearated Plug-in's package.
 * Plug-in's package namespace => com.example
 *   com.change_vision.astah.extension.plugin => X
 *   com.example                              => O
 *   com.example.internal                     => O
 *   learning                                 => X
 */
package com.example.internal;

import javax.swing.JFrame;

import com.change_vision.astah.extension.plugin.util.exception.APIException;
import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.BasicModelEditor;
import com.change_vision.jude.api.inf.editor.ClassDiagramEditor;
import com.change_vision.jude.api.inf.editor.IDiagramEditorFactory;
import com.change_vision.jude.api.inf.editor.IModelEditorFactory;
import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.exception.InvalidUsingException;
import com.change_vision.jude.api.inf.model.IClassDiagram;
import com.change_vision.jude.api.inf.project.ProjectAccessor;
import com.change_vision.jude.api.inf.view.IDiagramViewManager;
import com.change_vision.jude.api.inf.view.IViewManager;

/**
 * A class containing utilities easing astah* API operation
 * Instance must be created before this class is used.
 */
public class AstahAPIUtils {

  /**
   * Get diagramViewManager
   */
  public IDiagramViewManager getDiagramViewManager() {
    IViewManager viewManager = getViewManager();
      IDiagramViewManager diagramViewManager = viewManager.getDiagramViewManager();
    return diagramViewManager;
  }


  /**
   * Get ClassDiagramEditor by which models on class diagrams can be modified
   */
  public ClassDiagramEditor getClassDiagramEditor() {
    try {
      return getDiagramEditorFactory().getClassDiagramEditor();
    } catch (InvalidUsingException e) {
      throw new APIException(e);
    }
  }

  /**
   * Get BasicModelEditor by which basic models can be modified
   *
   * @return BasicModelEditor
   */
  public BasicModelEditor getBasicModelEditor() {
    try {
      return getModelEditorFactory().getBasicModelEditor();
    } catch (InvalidEditingException e) {
      throw new APIException(e);
    }
  }

  /**
   * Get ProjectAccessor by which astah* project can be operated
   */
  public ProjectAccessor getProjectAccessor() {
    ProjectAccessor projectAccessor = null;
    try {
      AstahAPI api = AstahAPI.getAstahAPI();
      projectAccessor = api.getProjectAccessor();
    } catch (ClassNotFoundException e) {
          throw new IllegalStateException(e);
    }
    if(projectAccessor == null) throw new IllegalStateException("projectAccessor is null.");
    return projectAccessor;
  }

  /**
   * Get JFrame representing the main window of astah*
   *
   * @return JFrame
   */
  public JFrame getMainFrame() {
    return getProjectAccessor().getViewManager().getMainFrame();
  }

  /**
   * Get the edition of running astah*
   */
  public String getEdition() {
    return getProjectAccessor().getAstahEdition();
  }

  private IViewManager getViewManager() {
    ProjectAccessor projectAccessor = getProjectAccessor();
    IViewManager viewManager = projectAccessor.getViewManager();
    if(viewManager == null) throw new IllegalStateException("ViewManager is null.");
    return viewManager;
  }

  private IModelEditorFactory getModelEditorFactory() {
    ProjectAccessor projectAccessor = getProjectAccessor();
    IModelEditorFactory modelEditorFactory = projectAccessor.getModelEditorFactory();
    if(modelEditorFactory == null) throw new IllegalStateException("modelEditorFactory is null.");
    return modelEditorFactory;
  }

  private IDiagramEditorFactory getDiagramEditorFactory() {
    ProjectAccessor projectAccessor = getProjectAccessor();
    IDiagramEditorFactory diagramEditorFactory = projectAccessor.getDiagramEditorFactory();
    if(diagramEditorFactory == null) throw new IllegalStateException("diagramEditorFactory is null.");
    return diagramEditorFactory;
  }

}
