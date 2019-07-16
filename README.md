# GoogleTextToSpeech4Java
Easy way to use Google Cloud Text-to-Speech API using JAVA

## Dependency

```
    <repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
    </repositories>


    <dependency>
        <groupId>com.github.tecnologiabasica</groupId>
        <artifactId>GoogleTextToSpeechAPI4Java</artifactId>
        <version>0.1.0</version>
    </dependency>
```

## API KEY

To use the Google Speech-to-Text API, you need to enable API_KEY. More information: https://cloud.google.com/speech-to-text/

This library will search file .googlecloud.properties in the home diretory. The key must be in the variable 'apiKey':

```
    apiKey=AIza...
```

If you want to set the apiKey hard coded, follow this instruction:

```
    JCommons.getInstance().setApiKey("[your_key]");
```

## Example

```
    public static void main(String[] args) {

        String audioEncoding = "LINEAR16";
        double pitch = -2;
        double speakingRate = 0.9;
        String text = "Olá. Obrigado pelo seu contato. Em que posso ajudá-lo?";
        String languageCode = "pt-BR";
        String name = "pt-BR-Wavenet-A";
        String audioContent = null;

        GoogleTextToSpeechAPI googleTextToSpeechAPI = new GoogleTextToSpeechAPI();
        audioContent = googleTextToSpeechAPI.synthesize(audioEncoding, pitch, speakingRate, text, languageCode, name);
        if (audioContent != null && !audioContent.isEmpty()) {
            try {
                String filePath = JCommons.getInstance().getHomeDir() + "/Downloads/audio.wav";
                InputStream inputStream = JBase64Util.convertBase64ToInputStream(audioContent);
                System.out.println("Write file " + filePath + " with size " + inputStream.available());
                JFileUtil.saveFile(inputStream, filePath);
            } catch (IOException ex) {
                Logger.getLogger(JLauncher.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("statusCode: " + googleTextToSpeechAPI.getStatusCode());
            System.out.println("message: " + googleTextToSpeechAPI.getMessage());
        }
        System.exit(0);

    }
```

## Authors

* **Afonso Henrique** - *Initial work* - [afonsohmm](https://github.com/afonsohmm)

## License

This project is licensed under the GNU GENERAL PUBLIC LICENSE V2 - see the [LICENSE](LICENSE) file for details