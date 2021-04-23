import sys
from collections import deque

m_dirs = (
    (-1, 0),
    (0, -1),
    (1,  0),
    (0,  1),
)
h_dirs = (
    (-1, -2),
    (-2, -1),
    (-2,  1),
    (-1,  2),
    ( 1,  2),
    ( 2,  1),
    ( 2, -1),
    ( 1, -2),
)

def main():
    pan, W, H, K = init()
    if W == H == 1:
        print(0)
        return
    
    # 너비우선탐색 until 끝까지 갈 때까지
    # input: pan, x, y
    # output: minimum count
    print(bfs_pan_until_corner(pan, W, H, 0, 0, K))

def init():
    K = int(sys.stdin.readline())
    W, H = map(int, sys.stdin.readline().split())
    return [list(map(int, sys.stdin.readline().split())) for _ in range(H)], W, H, K

def bfs_pan_until_corner(pan, W, H, start_x, start_y, K):

    class _Node:
        def __init__(self, x, y, horse_cnt, move_cnt):
            self.x = x
            self.y = y
            self.horse_cnt = horse_cnt
            self.move_cnt = move_cnt

    q = deque([_Node(start_x, start_y, 0, 0)])
    visited = [[[False for _ in range(K+1)] for _ in range(H)] for _ in range(W)]
    while q:
        node = q.popleft()
        x = node.x
        y = node.y
        count = node.move_cnt
        horse_cnt = node.horse_cnt

        if x == W-1 and y == H-1:
            return count

        for d in m_dirs:
            cy, cx = y + d[0], x + d[1]
            if not (0 <= cx < W and 0 <= cy < H): continue
            if pan[cy][cx] == 1: continue
            if not visited[cx][cy][horse_cnt]:
                q.append(_Node(cx, cy, horse_cnt, count+1))
                visited[cx][cy][horse_cnt] = True

        if horse_cnt < K:
            for d in h_dirs:
                cy, cx = y + d[0], x + d[1]
                if not (0 <= cx < W and 0 <= cy < H): continue
                if pan[cy][cx] == 1: continue
                if not visited[cx][cy][horse_cnt+1]:
                    q.append(_Node(cx, cy, horse_cnt+1, count+1))
                    visited[cx][cy][horse_cnt+1] = True

    return -1

main()