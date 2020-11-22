#!/usr/bin/env python
# coding=utf-8


import os
import sys
import jieba
import warnings
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn import metrics


warnings.filterwarnings('ignore')


if sys.version.startswith('2.'):
    reload(sys)
    sys.setdefaultencoding('utf-8')


def load_file(file_path):
    with open(file_path) as f:
        lines = f.readlines()

    titles = []
    labels = []

    for line in lines:
        line = line.encode('unicode-escape').decode('unicode-escape')
        line = line.strip().rstrip('\n')

        _lines = line.split('---')
        if len(_lines) != 2:
            continue

        label, title = _lines
        words = jieba.cut(title)

        s = ''
        for w in words:
            s += w + ' '

        s = s.strip()

        titles.append(s)
        labels.append(label)


    return titles, labels


def load_data(_dir):
    file_list = os.listdir(_dir)

    titles_list = []
    labels_list = []

    for file_name in file_list:
        file_path = _dir + '/' + file_name

        titles, labels = load_file(file_path)

        titles_list += titles
        labels_list += labels

    return titles_list, labels_list


def load_stopwords(file_path):
    with open(file_path) as f:
        lines = f.readlines()

    words = []
    for line in lines:
        line = line.encode('unicode-escape').decode('unicode-escape')
        line = line.strip('\n')
        words.append(line)

    return words


if __name__ == '__main__':
    # 加载停用词
    stop_words = load_stopwords('stop_word/stopword.txt')

    # 加载训练数据
    train_datas, train_labels = load_data('train_data')

    # 加载测试数据
    test_datas, test_labels = load_data('test_data')

    # 计算单词权重
    tf = TfidfVectorizer(stop_words = stop_words, max_df=0.5)
    train_features = tf.fit_transform(train_datas)
    test_features = tf.transform(test_datas) 

    # 多项式贝叶斯分类器
    clf = MultinomialNB(alpha = 0.001).fit(train_features, train_labels)

    # 预测数据
    predicted_labels = clf.predict(test_features)

    # 计算准确率
    score = metrics.accuracy_score(test_labels, predicted_labels)
    print score
