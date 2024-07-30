DEST_DIR="$HOME/codection/test"

# 폴더가 존재하지 않으면 생성하고 클론
if [ ! -d "$DEST_DIR" ]; then
    mkdir -p "$DEST_DIR"
    git clone https://github.com/SWM-Codection/Git-Test.git "$DEST_DIR"
fi
