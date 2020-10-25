import configparser

config = configparser.ConfigParser()
config['log'] = {
    'LEVEL': 'debug',
    'PATH': '/path/to/log/'
}
# config.iniに書き出し
with open('config.ini', 'w') as config_file:
    config.write(config_file)

# config.iniの読み込み
config.read('config.ini')
print(config['log'])
print(config['log']['LEVEL'])
print(config['log']['PATH'])
