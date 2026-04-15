# Git Operations Demonstration Log

This document records the Git operations performed for Task 19.

## 1. Initializing the Repository
Command: `git init`
Output: `Initialized empty Git repository in .../task19_sample_project/.git/`

## 2. Staging and Initial Commit
Commands:
```bash
echo "# Sample Project" > README.md
git add README.md
git commit -m "Initial commit"
```
Outcome: README.md was staged and committed to the local `master` branch.

## 3. Managing Multiple Files
Commands:
```bash
echo "<html>..." > index.html
echo "body { ... }" > styles.css
git add index.html styles.css
git commit -m "Add basic HTML and CSS files"
```
Outcome: Multiple files were staged and committed together, demonstrating versioning of features.

## 4. Viewing Version History
Command: `git log --oneline`
Output:
```
d4c808e Add basic HTML and CSS files
a719794 Initial commit
```

## 5. Remote Interaction (Main Workspace)
Commands:
```bash
git add task18_unit_testing task19_sample_project
git commit -m "Task 18 & 19 implementation"
git push origin main
```
Outcome: Files were synchronized with the remote GitHub repository: `https://github.com/vtu25256-crypto/fulstackdevelopment-E1slot-25256.git`
