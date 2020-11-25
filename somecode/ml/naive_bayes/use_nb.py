#!/usr/bin/env python
# coding=utf-8


import jieba
import warnings
from sklearn.externals import joblib

warnings.filterwarnings('ignore')


MODEL = None
TF = None


def load_model(model_path, tf_path):
    global MODEL 
    global TF

    MODEL = joblib.load(model_path)
    TF = joblib.load(tf_path)


def nb_predict(title):
    assert MODEL != None and TF != None
    
    words = jieba.cut(title)
    s = ' '.join(words)

    test_features = TF.transform([s]) 
    predicted_labels = MODEL.predict(test_features)

    return predicted_labels[0]


if __name__ == '__main__':
    load_model('nb.pkl', 'tf.pkl')
    print nb_predict('东莞市场采购贸易联网信息平台参加部委首批联合验收')
    print nb_predict('留在中超了！踢进生死战决胜一球，武汉卓尔保级成功')
    print nb_predict('陈思诚全新系列电影《外太空的莫扎特》首曝海报 黄渤、荣梓杉演父子')
    print nb_predict('红薯的好处 常吃这种食物能够帮你减肥')
