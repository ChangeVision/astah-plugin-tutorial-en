How to release a plugin
===============================

By setting <properties> tags named astah-version and astah-edition in pom.xml before a plugin is released, The version of the Astah by which the plugin is developped and the edition on which the plugin can run can be limitted.  

.. code-block:: xml

  <properties>
    <bundle.symbolicName>com.change_vision.astah.sample</bundle.symbolicName>
    <bundle.namespace>com.change_vision.astah</bundle.namespace>
    <plugin.install>true</plugin.install>
    <astah.version>6.6</astah.version>
    <astah.edition>all</astah.edition>
  </properties>

The version of the Astah by which the plugin is developped should be set as osstat-version, otherwise the version of the Astah running the plugin cannot be limitted.
Keys for astah-edition are listed in the table below. 

================== =======================
Edition             Value
================== =======================
All editions       blank, all, *
professional       pro, professional
UML                uml, UML
community          com, Community
================== =======================
