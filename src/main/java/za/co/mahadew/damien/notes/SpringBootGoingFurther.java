/**
 * Created by DAMIEN6 on 26/10/2016.
 */
package za.co.mahadew.damien.notes;

/**
 * Customizing spring boot
 *      application.properties
 *      replacing generated beans
 *      selectively disabling auto configuration
 *
 *  Application.properties
 *      spring boot looks for application.properties in these locations (in this order)
 *          1. /config
 *          2. the working directory
 *          3. classpath root
 *      creates a property source based on these files
 *
 *  @Conditional annotations
 *      Allow conditional bean creation
 *          only create if other bean exists(or dont exists)
 *          see {@link za.co.mahadew.damien.SpringExamPrepSpringBootApplicationWithWar}
 */
