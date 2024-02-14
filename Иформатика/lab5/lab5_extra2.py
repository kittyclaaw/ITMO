import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns


df = pd.read_csv('SPFB.RTS-12.18_180901_181231.csv')
df['date'] = pd.to_datetime(df['<DATE>'])
df_11 = df[(df['date'].dt.day == 11) & ((df['date'].dt.month == 9) | (df['date'].dt.month == 10) | (df['date'].dt.month == 12))]
df_13 = df[(df['date'].dt.day == 13) & (df['date'].dt.month == 11)]


agg_df = pd.concat([df_11, df_13])
agg_df['month_name'] = agg_df['date'].dt.month
agg_df.groupby('month_name')[['<OPEN>', '<HIGH>', '<LOW>', '<CLOSE>']].boxplot(subplots=False, rot=15, fontsize=10, figsize=(14,10))


september_11_df = df[(df['date'].dt.day == 11) & (df['date'].dt.month == 9)]
fig = plt.figure(figsize =(10, 7))
plt.title("September 11th")
september_11_df[['<OPEN>', '<HIGH>', '<LOW>', '<CLOSE>']].boxplot(figsize=(14,10))
plt.show()


october_11_df = df[(df['date'].dt.day == 11) & (df['date'].dt.month == 10)]
fig = plt.figure(figsize =(10, 7))
plt.title("October 11th")
october_11_df[['<OPEN>', '<HIGH>', '<LOW>', '<CLOSE>']].boxplot(figsize=(14,10))
plt.show()


november_13_df = df[(df['date'].dt.day == 13) & (df['date'].dt.month == 11)]
fig = plt.figure(figsize =(10, 7))
plt.title("November 13th")
november_13_df[['<OPEN>', '<HIGH>', '<LOW>', '<CLOSE>']].boxplot(figsize=(14,10))
plt.show()


december_11_df = df[(df['date'].dt.day == 11) & (df['date'].dt.month == 12)]
fig = plt.figure(figsize =(10, 7))
plt.title("December 11th")
december_11_df[['<OPEN>', '<HIGH>', '<LOW>', '<CLOSE>']].boxplot(figsize=(14,10))
plt.show()
