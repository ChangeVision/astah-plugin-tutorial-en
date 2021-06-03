
.. astah*のプラグイン機構の仕組み

Astah Plug-in architecture
=======================================================

.. figure:: images/archtecture.png
   :width: 600
   :alt: astah* plugin archtecture

.. astah*のプラグイン機構は起動時に、インストールフォルダ下のpluginsフォルダにあるプラグインファイルをロードします。プラグインファイルの拡張子は「jar」です。しかし、astah*がプラグイン機構の基盤として利用している、OSGi Runtime [#osgi]_ で読み込める形式であるBundleになっている必要があります｡

Astah loads all the Plug-ins that are stored in "plugin" folder in Astah's Install folder when you launch Astah. The Plug-in files need to be .jar format and also to be OSGi bundle because Astah's Plug-ins architecture uses OSGi [#osgi]_ Runtime.

.. astah*プラグインの開発中､インストールフォルダ配下にコピーしなくてもよいように、また、Bundleへのパッケージングを自動的に行うなど、開発を楽にする開発環境を用意しています。それではastah* プラグイン開発環境を構築してみましょう。

We've prepared SDK [#develop]_ for you to develop Astah Plug-ins with which automatically packages OSGi bundle and also allows you to use Plug-ins on Astah without storing them in the "plugin" folder in Astah Install folder during your development of Plug-ins. Now let's set up the development environment for Astah Plug-ins.

.. このチュートリアルの作成例はexamples/tutorialsampleの下に同梱されています。もしうまく動かない場合は参考にしてください。

You can find all the samples used in this tutorial in examples/tutorialsamples. Please refer to them if your Plug-in did not work on Astah.

.. rubric:: Footnotes
.. [#osgi] `http://www.osgi.org/ <http://www.osgi.org/>`_
.. [#develop] `http://astah.net/features/plugins#develop <http://astah.net/features/plugins#develop>`_
