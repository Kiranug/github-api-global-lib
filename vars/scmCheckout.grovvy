// check out repo
def gitCheckOut(repo_url,repo_branch,repo_credential) {
echo "started checkout repo"
git branch: "$repo_branch", changelog: false, credentialsId: "$repo_credential", url: "$repo_url"
echo "completed code checkout"
}
