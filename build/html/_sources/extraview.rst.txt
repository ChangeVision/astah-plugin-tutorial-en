
.. 拡張タブビューを作ってみましょう。

Let's add an extended view to Astah
=======================================================

.. astah*プラグインには、拡張タブビューがあります。これを使うと、例えばクラス情報のサマリを一覧にしてastah*上で見ることができるプラグインを作成できます。ここでは、”hello world”という文字列を表示する拡張タブビューを作成する方法を紹介します。

Astah Plug-in can add an extra view in Astah. For example, you can make a view to show a list of class summary or whatever you would like to show on Astah. So in this page, let's create a Plug-in to add an extended view to Astah. And let's make it show just a "hello world" text on there as an easy example. 


.. figure:: images/extend-view.png
   :width: 503
   :alt: ex.Extra tab view
   
.. 拡張タブビューを実装しましょう

Creating an extended view
----------------------------------------------------------

.. 拡張タブビューはIPluginExtraTabViewインターフェースの実装クラスとして定義します。下記のソースコードは、IPluginExtraTabViewを実装したHolloWorldViewの例です。

To add an extended view, use IPluginExtraTabView interface. Below is a sample of the HelloWoroldView which implements the IPluginExtraTabView.

.. literalinclude:: _snippets/HelloWorldView.java
   :language: java
   :linenos:

.. getComponent()は表など拡張タブビュー上に表示されるコンテンツをastah*に返します。例では、拡張タブビュー上に”hello world”を表示するHelloWorldViewインスタンスを返しています。拡張タブビューのタイトルはgetTitle()で定義します。

The getComponent() tells Astah what to show on the extended tab view such as a table. In our sample, the instance of a JPanel with a JLabel is returned to Astah by the getComponent(). And the label on the extended tab should be defined in the getTitle(). 

.. ProjectEventListenerインターフェースを実装したクラスは、astah*が現在開いているモデルのオブザーバーです。クラスの追加や削除などモデルに変更があった場合、projectChangedメソッドが呼ばれます。

A class implementing ProjectEventListener interface is an observer which keeps watching the models on current Astah. And the projectChanged() method will be called when there was a change in models such as adding/deleting of classes.

.. 拡張タブビューをastah*に追加しましょう

Adding an extended view to Astah
-------------------------------------------------------

.. 続いてplugin.xmlに拡張タブビューの追加をしましょう。

Next, let's write the plugin.xml to add the extended view to Astah.

.. literalinclude:: _snippets/plugin_extraview.xml
   :language: xml
   :linenos:

.. 各タグの意味は下記のとおりです。

.. 英語版では、この一文無くてもOKだと思います。

=================== ========= ======== =============================================
Tag name            Attribute Required  Description                                       
=================== ========= ======== =============================================
extension            \          o      Specify extension point                      
\                    point      o      Specify com.change_vision.astah.ui.view      
view                 \          o      Specify view configuration                   
\                    id         o      View's ID                                    
\                    type       o      Specify the location of the view             
\                    \          \      extraTab if you put the view  on ExtraView   
\                    class      o      Specify implementation of the class          
=================== ========= ======== =============================================

.. これで拡張タブビューの追加ができました。

Now an extended view has been added to Astah.
