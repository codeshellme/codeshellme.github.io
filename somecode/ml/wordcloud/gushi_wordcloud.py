#!/usr/bin/env python
# coding=utf-8


import os
import sys
import jieba
from wordcloud import WordCloud


if sys.version.startswith('2.'):
    reload(sys)
    sys.setdefaultencoding('utf-8')


# 去掉一些作者的名字
STOPWORDS = [
        u'李白', u'杜甫', u'辛弃疾', u'李清照', u'毛泽东', u'苏轼',
        u'李商隐', u'王维', u'白居易', u'李煜', u'杜牧',
        ]


def load_file(file_path):
    if sys.version.startswith('2.'):
        with open(file_path) as f:
            lines = f.readlines()
    else:
        with open(file_path, encoding='utf-8') as f:
            lines = f.readlines()


    content = ''

    for line in lines:
        line = line.encode('unicode-escape').decode('unicode-escape')
        line = line.strip().rstrip('\n')

        content += line

    words = jieba.cut(content)

    l = []
    for w in words:
        if len(w) < 2: continue

        l.append(w)

    return ' '.join(l)


# 测试用
def count(content):
    words = content.split(' ')

    keys = {}
    for w in words:
        if w in keys:
            keys[w] += 1
        else:
            keys[w] = 1

    # 按照值排序
    l = sorted(keys.items(), key = lambda kv:(kv[1], kv[0]), reverse=True)
    for i in l:
        w, n = i
        if n < 10: continue
        # print w, n

    return l


if __name__ == '__main__':
    file_path = './gushi.txt'
    content = load_file(file_path)
    # l = count(content)

    wc = WordCloud(
            font_path="./SimHei.ttf",
            stopwords=STOPWORDS,
            width=2000, height=1200)

    wc.generate(content)
    import pdb
    pdb.set_trace()
    wc.to_file("wordcloud.jpg")
