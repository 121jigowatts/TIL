# datetime

import datetime

now = datetime.datetime.now()
print(now)
print(now.isoformat())
print(now.strftime('%Y/%m/%d %H_%M_%S.%f'))

today = datetime.date.today()
print(today)

a_datetime = datetime.datetime(year=2020, month=1, day=1,
                               hour=12, minute=34, second=50, microsecond=600)
print(a_datetime)

time_goes_by = datetime.timedelta(days=10000)
print(now - time_goes_by)
