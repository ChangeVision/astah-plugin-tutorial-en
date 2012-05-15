Astah Plug-in snippets
=============================

Astah API utilities
-----------------------------

Some methods easing your Astah model operation

.. literalinclude:: _snippets/AstahModelUtils.java
   :language: java
   :linenos:

Methods for handling Astah API

.. literalinclude:: _snippets/AstahAPIUtils.java
   :language: java
   :linenos:

How to create a menu
-----------------------------
Please get detailed snippets by reading the tutorial or analyzing the tutorialexample project.

An example of plugin.xml

.. literalinclude:: _snippets/plugin_menu.xml
   :language: xml
   :linenos:

An example of action

.. literalinclude:: _snippets/HelloWorldAction.java
   :language: java
   :linenos:

How to create an extention view
-------------------------------
Please get detailed snippets by reading the tutorial or analyzing the tutorialexample project.

An example of plugin.xml

.. literalinclude:: _snippets/plugin_extraview.xml
   :language: xml
   :linenos:

An example of view

.. literalinclude:: _snippets/HelloWorldView.java
   :language: java
   :linenos:

How to extend Drag and Drop
-----------------------------

Please get detailed snippets by analyzing the com.change_vision.astah.extension.plugin.drag_and_drop_example project.
To add DropTargetListener during the initialization of a plugin, Activator#start(BundleContext context) should be implemented.

.. literalinclude:: _snippets/Activator.java
   :language: java
   :linenos:

An example showing how to implement DropTargetListener

.. literalinclude:: _snippets/ClassDiagramDropExtension.java
   :language: java
   :linenos:

