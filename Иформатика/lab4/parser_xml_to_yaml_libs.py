import yaml
import xmltodict


input_FILE = open('Myxml.xml', 'r', encoding="utf-8")
file = input_FILE.read()

pyObj = xmltodict.parse(file)
yamlDoc = yaml.dump(pyObj, encoding=None, allow_unicode=True)
output_FILE = open('Myyaml.yaml', 'w', encoding="utf-8")
file = output_FILE.write(yamlDoc)