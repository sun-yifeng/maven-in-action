# create by sunyf
# 这里写你的仓库路径 https://blog.csdn.net/u011990675/article/details/80066897
REPOSITORY_PATH=~/Documents/tools/repository
echo 正在搜索...
find $REPOSITORY_PATH -name "*lastUpdated*" | xargs rm -fr
echo 搜索完