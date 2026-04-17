# LeetCode Solutions

个人 LeetCode 刷题仓库，当前以 Java 题解为主，按题型分类整理，便于复习、查找和在 IntelliJ IDEA 中直接运行调试。

## 项目简介

- 主要覆盖 LeetCode Hot 150 及常见高频题。
- 代码以专题维度组织，而不是按题号单独建目录。
- 大多数题解文件都可以直接在 IDEA 中运行 `main` 方法进行本地验证。

截至 2026-04-17，仓库中共包含 `137` 个 `.java` 文件。

## 仓库结构

当前项目根目录主要按算法专题划分：

```text
leetcode-solutions/
├── AboutArray/
├── Backtracking/
├── BinarySearch/
├── BinaryTree/
├── BitwiseOperation/
├── DivideConquer/
├── DoublePointer/
├── DynamicProgramming/
├── HashTable/
├── Heap/
├── InterviewQuestions/
├── LinkedList/
├── Math/
├── SlidingWindow/
├── graph/
├── interval/
├── matrix/
├── stack/
└── README.md
```

## 命名约定

- 题解类通常命名为 `Lc题号.java`，例如 `Lc12.java`、`Lc124.java`。
- 少数设计题或数据结构题会使用更贴近题意的类名，例如 `BSTIterator.java`、`MiniStack.java`、`RandomizedSet.java`。
- 包名通常与所在目录保持一致，例如 `AboutArray/Lc12.java` 对应 `package AboutArray;`。

## 如何使用

### 方式一：在 IntelliJ IDEA 中查看和运行

1. 使用 IDEA 打开项目根目录。
2. 进入对应专题目录，找到目标题解文件。
3. 根据文件中的示例输入调整测试数据。
4. 直接运行类中的 `main` 方法，查看输出结果并调试。

### 方式二：按专题复习

如果你是按知识点刷题，可以从以下目录切入：

- `BinaryTree`：二叉树与 BST 相关题目
- `DynamicProgramming`：动态规划
- `Backtracking`：回溯
- `DoublePointer` / `SlidingWindow`：双指针与滑动窗口
- `HashTable`：哈希表与集合映射
- `BinarySearch`：二分搜索
- `LinkedList` / `stack` / `Heap`：基础数据结构专题

## 适合什么场景

- 按专题整理自己的刷题记录
- 面试前集中复习高频算法题
- 在 IDEA 中单题调试，快速验证思路
- 对照不同题型，沉淀常见解题模板

## 说明

- 这是个人刷题记录仓库，重点在于持续积累与复盘。
- 不同题目的代码风格可能会随着刷题阶段逐步调整。
- 当前 README 仅基于仓库结构和文件组织方式整理，不对每道题的具体实现细节做展开说明。
