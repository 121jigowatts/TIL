import logging
import settings

# Defaultはwarning
# https://docs.python.org/ja/3/library/logging.html
# formatter = '%(asctime)s [%(levelname)s]:%(message)s'
# logging.basicConfig(level=logging.DEBUG, format=formatter)

logging.critical('critical [%s]', 'origin')
logging.error('error [%s]', 'origin')
logging.warning('warning [%s]', 'origin')
logging.info('info [%s]', 'origin')
logging.debug('debug [%s]', 'origin')

print('##############################')

logger = logging.getLogger(__name__)
logger.critical('critical[logger]')
logger.error('error[logger]')
logger.warning('warning[logger]')
logger.info('info[logger]')
logger.debug('debug[logger]')

print('##############################')

logger = logging.getLogger('simpleExample')
logger.critical('critical[logger]')
logger.error('error[logger]')
logger.warning('warning[logger]')
logger.info('info[logger]')
logger.debug({
    'action': 'create',
    'status': 'fail',
    'message': 'Failed to create data.'
})
