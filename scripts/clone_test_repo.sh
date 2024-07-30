DEST_DIR="$HOME/codection/test"

# 폴더가 이미 존재하면 삭제
if [ -d "$DEST_DIR" ]; then
    rm -rf "$DEST_DIR"
fi

mkdir -p "$DEST_DIR"
git clone https://github.com/SWM-Codection/Git-Test.git "$DEST_DIR"
