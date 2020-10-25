import yaml

# yaml書き込み
with open('config.yml', 'w') as yaml_file:
    yaml.dump({
        'web': {
            'host': 'localhost',
            'port': '8080'
        },
        'db': {
            'host': 'localhost',
            'port': '5432'
        }
    }, yaml_file)

# yaml読み込み
with open('config.yml', 'r') as yaml_file:
    config = yaml.safe_load(yaml_file)
    print(config['web']['host'])
    print(config['web']['port'])
    print(config['db']['host'])
    print(config['db']['port'])
