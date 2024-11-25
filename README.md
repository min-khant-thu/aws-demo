# ローカル開発環境構築

## 事前にインストール必要な物

- git
- docker
- docker compose
- IDE もしくはテキストエディタ(VS Codeお勧め)

## VS codeの拡張一覧
### Java用
以下の拡張のインストール先はコンテナーです。
- Debugger for Java
- Extension Pack for Java
- Gradle for Java
- Language Support for Java(TM) by Red Hat
- Maven for java
- Project Manager for Java
- Spring Boot Dashboard
- Spring Boot Extension Pack
- Spring Boot Tools
- Spring Initializr Java Support
- Test Runner for Java

### Container用
- Remote - SSH
- Remote - SSH: Editing Configuration Files
- Remote - Tunnels
- Remote Development
- Remote Explorer
- Dev Containers
- WSL

## Dockerビルド
- リポジトリをローカルにクローンした後プロジェクトのルートディレクトリに以下のコマンでビルドを行う  
`docker compose build`  

- ビルドは問題なく完了したら以下のコマンドで起動  
`docker compose up -d`

- ２回目以降は `docker compose start` で起動できます。

- 止めたい場合は `docker compose stop` を実行

## Localstackの設定
以下のコマンドでlocalstackの初期設定を行う  
**`localstack-init/init.sh`の改行が `CRLF`になっている場合、`LF`に変更**

```
docker compose exec localstack bash
cd /var/localstack
sh ./init.sh
```
**localstackコンテナが再起動または停止された場合、コンテナ上に作成されているリソースが全部削除されます。
コンテナが再起動または起動された後、上記のコマンドを必ず実行してください。**

## SpringBootアプリの起動
- VS Codeで `Ctrl+Shift+P` を押して表示される中から `開発コンテナー：実行中のコンテナーにアタッチ`を選択
- ファイルディレクトリに `/app`を選択
- `SpringlocalstackApplication.java` クラスに `Run Java`でアプリを起動

### Hot Reload
- Hot Reloadをテストしたい場合、VS Codeの`実行＆デバッグ`タブから`実行＆デバッグ`ボタンを押して起動してください。
- ソースコードを修正した後、表示されているメニューから`Hot Code Replace`（雷アイコン）を押して最新版のソースコードをロードしてください。


## 確認
http://localhost:8080/customer/register にアクセスし、`お客様情報登録` 画面が表示されれば環境構築完了
