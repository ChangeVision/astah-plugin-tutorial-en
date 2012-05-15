.. Astah Plug-in SDK Document documentation master file, created by
   sphinx-quickstart on Mon Oct 03 16:49:51 2011.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

.. header::

    .. cssclass:: headertable

    +--+--------------+----------------------------+
    |  |              |         .. cssclass:: right|
    |  |              |                            |
    |  |###Section### | .. image:: images/logo.png |
    +--+--------------+----------------------------+
      
.. astah* Plug-in開発チュートリアル

Astah Plug-in Development Tutorial
=======================================================

..  astah*のプラグイン機構は、astah*に自作の機能を追加し、機能拡張を実現する仕組みです。astah*のプラグインを作成することで、メニューや拡張ビューなど、astah*のGUIに独自のコンポーネントを追加できます。

The Astah Plug-in architecture makes it possible for you to empower Astah by adding your own functions. You are able to add your own components like menu or extended views to Astah's GUI.

.. 本チュートリアルでは、サンプルを中心にastah*プラグインの作り方を紹介します。

In this tutorial, we will introduce you how to develop Plug-ins for Astah with a few samples.

.. チュートリアルで動作確認したバージョン

Prerequisites
-------------------------------------------------------

.. 本チュートリアルにおいて動作確認したバージョンは下記のとおりです｡下記のバージョン以外でも開発できますが､チュートリアルとは設定や画面が異なる場合があります。

Below is a table of software and its version that are used in this tutorial. You can use other versions of software, but please note that some settings or appearance of dialogs may look different than ones we have in this tutorial.

==================== ======================================
Software              Version
==================== ======================================
OS                    Windows7,Ubuntu Linux 11.10
Java                  Oracle JDK 7
Astah                 6.6(Professional, UML, Community)
Eclipse               3.7.1
IntelliJ IDEA         11.1
==================== ======================================

TOC:

.. toctree::
   :maxdepth: 1

   overview
   devenv
   helloworld
   example
   extraview
   installplugin
   releaseplugin
   apilist
   appendixA
   appendixB
   snippets
