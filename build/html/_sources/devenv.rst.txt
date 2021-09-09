
.. astah*のプラグインの開発環境を構築しましょう

Let's set up the development environment for Astah Plug-ins
=============================================================

.. astah*のプラグイン開発環境として、`astah* professional用 <https://astah.change-vision.com/files/plugin/astah-plugin-sdk-latest.zip>`_ と `astah* System Safety用 <https://astah.change-vision.com/files/plugin/safety-plugin-sdk-latest.zip>`_ のastah* Plug-in SDKを配布しています。このSDKはMaven 3をベースにカスタマイズしたものです。

We provide `Astah Plug-in SDK <http://astah.net/features/plugins#develop>`_ and `Astah System Safety Plug-in SDK <https://astah.change-vision.com/files/plugin/safety-plugin-sdk-latest.zip>`_ on our website which is based on Maven3.

.. ここではastah*のプラグインの開発環境を構築しましょう。`なお、astah*プラグイン開発環境のシステム要件は、astah*に準じます。 <http://astah.change-vision.com/ja/product/astah-requirement.html>`_

Let's set up your development environment for Astah Plug-ins! `System Requirements for this environment are same as Astah's <http://astah.change-vision.com/en/product/astah-requirement.html>`_.

.. まず配布されているastah* Plug-in SDKを適当なフォルダに展開します。次に以下に挙げる環境変数を設定します。


..
  * 環境変数「ASDK_HOME」を追加し、展開したフォルダを指定する。
  * 環境変数「PATH」にastah* Plug-in SDKの実行ファイルがある「%ASDK_HOME%\\bin」フォルダ(Linux/Mac OS Xをお使いであれば「$ASDK_HOME/bin」)を追加する。

At first, extract the Astah Plug-in SDK to a folder and then set the following environment variables.

* Add [ASDK_HOME] and specify the folder where you deployed the Astah Plug-in SDK ::

   e.g.) set ASDK_HOME=C:\dev\astah-plugin-SDK-1.0

* Specify "%ASDK_HOME%\\bin" ("$ASDK_HOME/bin" if you are using Linux or Mac OS X) folder to [PATH], where the excutable files of Astah Plug-in SDK's exist ::

   e.g.) set PATH=%ASDK_HOME%\bin;%PATH%

.. 以上の作業が終了したら、次のコマンドを入力してみましょう。 ::

Then run the command below. ::

  > asdk

.. 以下のような出力が得られれば､astah* Plug-in SDKのインストールは完了です。 ::

If the below appears, that means installation of Astah Plug-in SDK is completed. ::

  > astah* Plug-in SDK version: 1.0

..
  次にastah* Plug-in SDKからastah*が起動できることを確認するために、下記のコマンドを入力してみましょう｡ ::

Now, run the command below to make sure Astah launches on the SDK. ::

  > astah-launch

..
  うまく行くと、お使いのastah*が起動されます。

Then Astah should launch now.

..  もし、64bit版Windowsをご利用で、32bit版astah*をインストールしている場合や､デフォルトのパス以外にastah*をインストールしている場合は起動できません。パスを変更してインストールしているために、astah*を起動できない場合は、%ASDK_HOME%\\conf\\settings.xmlの中の<profile>タグに囲まれた部分を適切に設定します。お使いの「エディション」と「OS」に対応するID「astah-<エディション>-<os>」のプロファイルを適切なパスに修正してください。

..
  <profile>
    <id>astah-professional-windows</id> <!-- このIDの[professional]はastah*のエディション、[windows]はosです -->
    <activation>
      <activeByDefault>false</activeByDefault>
      <file>
        <exists>C:/astah-professional/astah-pro.jar</exists>  <!-- ココ -->
      </file>
    </activation>
    <properties>
      <astahPath>C:/astah-professional</astahPath>  <!--ココ -->
      <astahEdition>professional</astahEdition>
    </properties>
     <pluginRepositories>
       <pluginRepository>
         <id>local_astah_repository</id>
         <name>Local Astah* Plugin Repository</name>
         <url>file://${env.M2_HOME}/repository/</url>
         <layout>default</layout>
         <snapshots>
           <enabled>true</enabled>
         </snapshots>
         <releases>
           <updatePolicy>never</updatePolicy>
         </releases>
       </pluginRepository>
     </pluginRepositories>
  </profile>

.. Warning::

   If Astah doesn't launch by the command, please check the settings.xml and set the correct location, Astah's edition and OS you use in the <profile/> in the %ASDK_HOME%\\conf\\settings.xml as below.

.. code-block:: xml

   <profile>
     <id>astah-professional-windows</id> <!-- Specify the correct edition of Astah and OS you use.  -->
                                         <!-- In this case,Astah Professional is used on Windows. -->
     <activation>
       <activeByDefault>false</activeByDefault>
       <file>
         <exists>C:/Program Files/astah-professional/astah-pro.jar</exists>  <!-- Make sure to specify the correct path -->
       </file>
     </activation>
     <properties>
       <astahPath>C:/Program Files/astah-professional</astahPath>  <!-- Make sure to specify the correct path -->
       <astahEdition>professional</astahEdition>
     </properties>
      <pluginRepositories>
        <pluginRepository>
          <id>local_astah_repository</id>
          <name>Local Astah* Plugin Repository</name>
          <url>file://${env.M2_HOME}/repository/</url>
          <layout>default</layout>
          <snapshots>
            <enabled>true</enabled>
          </snapshots>
          <releases>
            <updatePolicy>never</updatePolicy>
          </releases>
        </pluginRepository>
      </pluginRepositories>
    </profile>

.. astah* Plug-in SDKは､内部でMaven 3を利用しています。
.. note::
  Astah Plug-in SDK is using Maven 3 internally.
