# Android-SampleApplication
 - Androidの雛形サンプルアプリです
 - アーキテクチャや非同期処理、UI構成、DataBindingなどを構築済み
 
## アーキテクチャについて
  - クリーンアーキテクチャとMVPアーキテクチャを採用
  
## 非同期処理
  - Coroutineを採用
  - Coroutineを手軽に使えるテンプレートを実装
  
## 例外処理について
  - 非同期通信関係の例外処理のテンプレートを実装
  
## UI構成について
  - MainActivityの上に3つのFragmentを実装
  - FragmentはBottomNavigationViewにより切り替え可能な仕様になっている
  - 利用頻度が高いと思われるListとGridのデザインを採用、両者ともRecyclerViewにより実装
  - Fragmentのうち一つにはViewPagerを設定し、その上で2つのFragmentによる管理(NestedFragment)を採用
  
## DataBindingについて
  - 双方向のDataBindingを行う
